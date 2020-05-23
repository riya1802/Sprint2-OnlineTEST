import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ViewallQuestionComponent } from './viewall-question/viewall-question.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { AddTestComponent } from './add-test/add-test.component';
import { ViewAllTestComponent } from './view-all-test/view-all-test.component';
import { AssignTestComponent } from './assign-test/assign-test.component';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { LoginComponent } from './login/login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { LogoutComponent } from './logout/logout.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { UpdateUserComponent } from './update-user/update-user.component';


const routes: Routes = [
  {path:"",redirectTo:"/login",pathMatch:"full"},
  {path:"login",component:LoginComponent},
  {path:"logout",component:LogoutComponent},
  {path:"adminHome",component:AdminHomeComponent},
  {path:"userHome",component:UserHomeComponent},
  {path:"viewAllQuestions",component:ViewallQuestionComponent},
  {path:"addQuestion",component:CreateQuestionComponent},
  {path:"addTest",component:AddTestComponent},
  {path:"viewAllTest",component:ViewAllTestComponent},
  {path:"assignTest",component:AssignTestComponent},
  {path:"viewAllUser",component:UserListComponent},
  {path:"addUser",component:CreateUserComponent},
  {path:"updateuser",component:UpdateUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
