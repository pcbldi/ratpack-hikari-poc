package models;

class Member {

  String firstName
  String lastName
  String bio
  String email
  String mobile
  Date joinDate
  Map metadata
  long id

  String getName(){
    "{first_name} {last_name}"
  }

}