Feature: Titel und Überschriften der Startseite
  Alle Titel entsprechen der Definition

  Scenario: Titel der Startseite
    Then Der Titel ist "Private | Swiss Life"
    
  Scenario: Titel von "Vorsorge- und Vermögensaufbau"
    Given Ich schliesse den Disclaimer
    When Ich klicke auf "Vorsorge- und Vermögensaufbau"
    Then Der Titel ist "Vorsorge- und Vermögensaufbau | Swiss Life"