I started by identifying common behaviors across different pen types like writing, refilling, and opening.

I created an abstract Pen class to capture shared state and behavior.

Then I used inheritance to model different pen types like BallPen and GelPen.

To decouple object creation from usage, I introduced a factory pattern.

Overall, I focused on making the design extensible and loosely coupled.



# 1. Factory Pattern 
## why coz ->provides a way to create objects without exposing the exact creation logic to the client
## Loose Coupling: The client code doesn't need to know the specific class it is instantiating; it only cares about the interface or abstract class.
## object creation code is in one place
## can easily add new types of objects 

PenFactory

“I used factory pattern to centralize object creation and reduce coupling with concrete classes.”


# 2. Open/Closed Principle

Adding new pen types doesn’t affect existing code

“System is open for extension but closed for modification.”


# 3. Abstraction

Pen abstract class

“I created an abstract Pen class to define common behavior while hiding implementation details

# 4. Encapsulation

inkLevel, isOpen are private/protected

“Internal state is encapsulated and modified only through methods like write and refill.”
# 5. Inheritance
BallPen, GelPen, FountainPen extend Pen

“Different pen types reuse common logic and specialize behavior.”

# 6. Polymorphism

Pen pen = PenFactory.getPen(...)

“Client interacts with Pen abstraction, and actual behavior is resolved at runtime.”
