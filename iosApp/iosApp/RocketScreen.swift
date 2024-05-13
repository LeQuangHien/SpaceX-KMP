//
//  RocketScreen.swift
//  iosApp
//
//  Created by Hien Le on 01.03.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import KMMViewModelSwiftUI
import KMPNativeCoroutinesAsync
import Shared
import SwiftUI

struct RocketScreen: View {

    @StateViewModel
    var viewModel = RocketViewModel(
        spaceXRepository: KoinDependencies().spaceXRepository
    )

    var body: some View {
        ZStack {
            if !viewModel.objects.isEmpty {
                NavigationStack {
                    ScrollView {
                        LazyVStack(alignment: .leading, spacing: 20) {
                            ForEach(viewModel.objects, id: \.flightNumber) { item in
                                NavigationLink(destination: DetailView(objectId: item.flightNumber)) {
                                    ObjectFrame(obj: item, onClick: {})
                                }
                                .buttonStyle(PlainButtonStyle())
                            }
                        }
                        .padding(.horizontal)
                    }
                }
            } else {
                Text("No data available")
            }
        }
    }
}

struct ObjectFrame: View {
    let obj: RocketLaunch
    let onClick: () -> Void

    var body: some View {
        VStack(alignment: .leading) {
            Text(obj.missionName)
                .font(.headline)
                .foregroundColor(.black)
            Text("Launch Year: \(obj.launchDateUTC)")
                .foregroundColor(.black)
            Text("Flight Number: \(obj.flightNumber)")
                .foregroundColor(.black)
            if let details = obj.details {
                Text("Details: \(details)")
                    .foregroundColor(.black)
            }
        }
    }
}
 





