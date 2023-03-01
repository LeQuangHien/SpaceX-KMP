//
//  RocketScreen.swift
//  iosApp
//
//  Created by Hien Le on 01.03.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketScreen: View {
    @StateObject private var viewModel = RocketViewModel()

    var body: some View {
        NavigationView {
            List(viewModel.uiState.rocketItems, id: \.flightNumber) { item in
                VStack(alignment: .leading) {
                    Text(item.mission)
                        .font(.headline)
                    Text("Launch Year: \(item.launchYear)")
                    Text("Flight Number: \(item.flightNumber)")
                    if let details = item.details {
                        Text("Details: \(details)")
                    }
                }
            }
            .navigationTitle("Rocket Launches")
            .task {
                await viewModel.loadItems()
            }
        }
    }
}

/*struct RocketScreen_Previews: PreviewProvider {
    static var previews: some View {
        let viewModel = RocketViewModel()
        viewModel.loadItems()
        return RocketScreen()
    }
}*/
 





