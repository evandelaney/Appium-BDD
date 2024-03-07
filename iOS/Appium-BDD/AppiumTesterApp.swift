//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import SwiftUI

@main
struct AppiumTesterApp: App {
    
    @StateObject private var state = AppState()
    
    var body: some Scene {
        WindowGroup {
            AppStateContainerView()
                .environmentObject(state)
        }
    }
}
