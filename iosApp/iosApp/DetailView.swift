import Foundation
import SwiftUI
import Shared

struct DetailView: View {
    let viewModel = DetailViewModel(
        spaceXRepository: KoinDependencies().spaceXRepository
    )

    let objectId: Int32

    @State
    var object: RocketLaunch? = nil

    var body: some View {
        VStack {
            if let obj = object {
                ObjectDetails(obj: obj)
            }
        }
        .task {
            for await obj in viewModel.getObject(objectId: objectId) {
                object = obj!
            }
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
