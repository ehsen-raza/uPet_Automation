Feature: Sign-up and add Image to profile

  Scenario: Customer Signs Up from login Page and uploads profile Image
    Given uPet application is launched
    When A new user is registered
    And Uploaded a profile picture
    Then Profile picture is updated