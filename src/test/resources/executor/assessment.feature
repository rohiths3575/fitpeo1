Feature: Caluculating Total Recurring Reimbursement

  Scenario Outline: Revenue Calculator page
  
    Given user should be in website
    When user clicks on Revenue Calculator 
    And user moves to scroller and sets number Total Individual Patient/Month 
    And user checks the scroller by manually entering the value "560"
    And user refreshes the page
    And user sets value again to eight twenty
    And user checks the boxes with CPT values of his choice
  
    Then user verifies the value of Total Recurring Reimbursement
     And closes the window
    
    