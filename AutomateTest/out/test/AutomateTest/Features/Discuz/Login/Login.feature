Feature: Login
Scenario: Login Discuz
  Given Open Discuz"http://localhost/bbsutf8"
  When Login in Discuz with "qtl" and "qtl"
  Then Login success