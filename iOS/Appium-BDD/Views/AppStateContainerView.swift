//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import SwiftUI

struct AppStateContainerView: View {
    
    @EnvironmentObject var state: AppState
    
    var body: some View {
        if state.state == .login {
            LoginView()
        }
        else if state.state == .home {
            HomeView()
        }
        else  {
            HelloWorldView()
        }
    }
}

#Preview {
    AppStateContainerView()
}
