Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "noora" and password "salainen1" and matching password confirmation are entered
        Then  a new user is created

    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  an invalid username "no" and password "salainen1" and matching password confirmation are entered
        Then  user is not created and error message is reported    

   Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  a valid username "noora" and too short password "sa" and matching password confirmation are entered
        Then  user is not created and error message about password is reported  

    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  valid username "noora" but nonmatching password "salainen1" and passwordConfirmation "salainen2" are entered
        Then  user is not created and error message about passwords not matching is reported    