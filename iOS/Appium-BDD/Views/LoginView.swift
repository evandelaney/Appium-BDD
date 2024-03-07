//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    
    @State var username: String = ""
    @State var password: String = ""
    @EnvironmentObject var state: AppState
    
    var body: some View {
        VStack {
            TextField(text: $username) {
                Text("Username")
            }
            .textFieldStyle(.roundedBorder)
            .padding([.top, .horizontal])
            .accessibilityIdentifier("username")
            
            SecureField(text: $password) {
                Text("Password")
            }
            .textFieldStyle(.roundedBorder)
            .padding()
            .accessibilityIdentifier("password")
            
            Button(action: { state.state = .home }) {
                Text("Log In")
            }
            .buttonStyle(.borderedProminent)
            .accessibilityIdentifier("login_button")
        }
        .padding()
    }
}

#Preview {
    LoginView()
}
