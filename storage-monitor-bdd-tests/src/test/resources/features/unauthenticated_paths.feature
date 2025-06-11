Feature: Unauthenticated path access

  Scenario Outline: Accessing path "<path>" without logging in
    When Navigating to path "<path>"
    Then Should be redirected to login page if should be redirected "<shouldRedirected>"

    Examples:
      | path         | shouldRedirected |
      | home         | true           |
      | storagelist  | true           |
      | products     | true           |
      | production   | true           |
      | login        | false          |
      | register     | false          |