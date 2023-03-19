import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import {UserService} from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService, private snack:MatSnackBar) { }

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
     // alert('User is Required !!');
     this.snack.open('User Name is required', 'Ok', {
       duration:3000
     });
      return;
    }
    //addUser : userService
    this.userService.addUser(this.user).subscribe(
      (data)=> {
        //success
        console.log("Success");
        console.log(this.user);
       // alert('User Registerd Successfully!!');
       Swal.fire('Success','User is Registered Successfully', 'success')

      },
      (error)=> {
        console.log(error);
        //alert('Somthing went Wrong!!!')
        Swal.fire('Error','Something went wrong!!' +error.message, 'error')

      }
    )
  }

}
