//
//  RocketScreen.swift
//  iosApp
//
//  Created by Hien Le on 01.03.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
import SafariServices

struct RocketScreen: View {
    @StateObject private var viewModel = RocketViewModel()
    @State private var selectedRocketItem: RocketItemUiState? = nil
    
    var body: some View {
        NavigationView {
            List(viewModel.uiState.rocketItems, id: \.flightNumber) { item in
                Button(action: {
                    selectedRocketItem = item
                }, label: {
                    VStack(alignment: .leading) {
                        Text(item.mission)
                            .font(.headline)
                            .foregroundColor(.black)
                        Text("Launch Year: \(item.launchYear)")
                            .foregroundColor(.black)
                        Text("Flight Number: \(item.flightNumber)")
                            .foregroundColor(.black)
                        if let details = item.details {
                            Text("Details: \(details)")
                                .foregroundColor(.black)
                        }
                    }
                })
            }
            .navigationTitle("Rocket Launches")
            .sheet(item: $selectedRocketItem) { item in
                if let url = URL(string: item.url ?? "") {
                    SafariView(url: url)
                }
            }
            .task {
                await viewModel.loadItems()
            }
        }
    }
}

struct SafariView: UIViewControllerRepresentable {
    let url: URL

    func makeUIViewController(context: Context) -> SFSafariViewController {
        let safariVC = SFSafariViewController(url: url)
        return safariVC
    }

    func updateUIViewController(_ uiViewController: SFSafariViewController, context: Context) {
        // No update needed
    }
}
 





