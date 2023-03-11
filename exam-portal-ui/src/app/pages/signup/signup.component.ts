import { Component, OnInit } from '@angular/core';
import {UserService} from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService) { }

  public user = {
    userName: '',
    password : '',
    firstName : '',
    lastName : '',
    email : '',
    mobileNumber : ''
  };

  ngOnInit(): void {
  }

  formSubmit() {
    console.log(this.user);
    if(this.user.userName== '' || this.user.userName== null) {
      alert('User is Required !!');
      return;
    }
    //addUser : userService
    this.userService.addUser(this.user).subscribe(
      (data)=> {
        //success
        console.log("Success");
        console.log(this.user);
        alert('User Registerd Successfully!!');

      },
      (error)=> {
        console.log(error);
        alert('Somthing went Wrong!!!')
      }
    )
  }

}
