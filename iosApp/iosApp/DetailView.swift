import Foundation
import SwiftUI
import Shared
import KMMViewModelSwiftUI
import KMPNativeCoroutinesAsync

struct DetailView: View {
    @StateViewModel
    var viewModel = DetailViewModel(
        spaceXRepository: KoinDependencies().spaceXRepository
    )

    let objectId: Int32


    var body: some View {
        VStack {
            if let obj = viewModel.rocketLaunch {
                ObjectDetails(obj: obj)
            }
        }
       .onAppear {
            viewModel.setId(objectId: objectId)
        }
    }
}

struct ObjectDetails: View {
    var obj: RocketLaunch

    var body: some View {
        ScrollView {

            VStack {
                VStack(alignment: .leading, spacing: 6) {
                    Text(obj.missionName)
                        .font(.title)

                    LabeledInfo(label: "Flight Number", data: String(obj.flightNumber))
                    LabeledInfo(label: "Launch Date", data: obj.launchDateUTC)
                    LabeledInfo(label: "Success", data: obj.launchSuccess?.description ?? "None")
                    if obj.details != nil {
                        LabeledInfo(label: "Details", data: obj.details ?? "None")
                    }
                }
                .padding(16)
            }
        }
    }
}

struct LabeledInfo: View {
    var label: String
    var data: String

    var body: some View {
        Spacer()
        Text("**\(label):** \(data)")
    }
}
