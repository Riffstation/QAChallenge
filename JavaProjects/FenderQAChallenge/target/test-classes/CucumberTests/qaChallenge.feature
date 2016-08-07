Feature: Fender QA challenge

Background:
Given Navigate to Fender electric guitars

Scenario: Fender QA Challenge basic scenario.

When Select a electric guitar which has stock
Then Add the guitar to the shopping cart
And Add the guitar to the shopping cart
When Navigate to the cart info
And Go to secure checkout
When Checkout as a guest
And Introduce a valid address
And Continue to billing step
Then We should be into checkout bill step

Scenario: If the guitar has not stock the button for notify user is displayed. 

When Select an electric guitar which has not stock
Then Is notify user link visible


