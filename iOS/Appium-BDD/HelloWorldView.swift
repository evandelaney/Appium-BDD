//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import SwiftUI

struct HelloWorldView: View {
    
    var body: some View {
        VStack {
            Image(systemName: "globe")
                .imageScale(.large)
                .foregroundStyle(.tint)
                .accessibilityIdentifier("icon")
            
            Text("Hello, world!")
                .accessibilityIdentifier("greeting")
        }
        .padding()
    }
}

#Preview {
    HelloWorldView()
}
