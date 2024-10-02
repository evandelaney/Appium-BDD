//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import SwiftUI

struct HelloWorldView: View {
    
    @EnvironmentObject private var state: AppState
    
    var body: some View {
        VStack {
            Spacer()
            Image(systemName: "globe")
                .imageScale(.large)
                .accessibilityIdentifier("icon")
            
            Text("Hello, world!")
                .accessibilityIdentifier("greeting")
            
            Spacer()
            
            HStack {
                Spacer()
                
                Button(action: { state.value = .login }) {
                    Text("Next")
                }
                .padding()
                .accessibilityIdentifier("next_button")
            }
        }
        .padding()
    }
}

#Preview {
    HelloWorldView()
}
