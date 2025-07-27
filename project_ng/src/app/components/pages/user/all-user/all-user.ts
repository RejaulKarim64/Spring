import { Component } from '@angular/core';
import { UserService } from '../../../../service/user-service';
import { User } from '../../../../model/user.model';

@Component({
  selector: 'app-all-user',
  standalone: false,
  templateUrl: './all-user.html',
  styleUrl: './all-user.css'
})
export class AllUser {


   users: User[] = [];

  constructor(
    private userService: UserService
  ) { }

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers() {

    this.userService.getAllEmp().subscribe({
      next: (res) => {
        this.users = res;

      },
      error: (err)=>{
        console.log(err);
      }

    });


  }


}
