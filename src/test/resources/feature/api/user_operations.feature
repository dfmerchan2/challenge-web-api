Feature: Perform different operations on the user

  Me as a PetStore user
  I want to perform the different actions on the user
  To purchase the correct operation of the application

  Scenario: Operations about user
    Given that "Diego" create and consult the new user in the system
    When Update and consult user information
    And delete the user successfully
    Then search for the user should see the message "User not found" and a 404 code