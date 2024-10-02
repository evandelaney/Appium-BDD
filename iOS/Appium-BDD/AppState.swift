//
//  Copyright © 2024 Evan DeLaney. All rights reserved.
//

import SwiftUI

final class AppState: ObservableObject {
    
    enum State {
        case helloWorld
        case login
        case home
    }
    
    @Published var value: State = .helloWorld
}
