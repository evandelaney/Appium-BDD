//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import SwiftUI

struct AppStateContainerView: View {
    
    @EnvironmentObject var state: AppState
    
    var body: some View {
        if state.value == .login {
            LoginView()
        }
        else if state.value == .home {
            HomeView()
        }
        else  {
            HelloWorldView()
        }
    }
}

#Preview {
    AppStateContainerView()
        .environmentObject(AppState())
}
