package models;

class Member {

  String first_name
  String last_name
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