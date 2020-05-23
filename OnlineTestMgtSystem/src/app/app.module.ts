import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { AddTestComponent } from './add-test/add-test.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AssignTestComponent } from './assign-test/assign-test.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { LogoutComponent } from './logout/logout.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { UserListComponent } from './user-list/user-list.component';
import { ViewAllTestComponent } from './view-all-test/view-all-test.component';
import { ViewallQuestionComponent } from './viewall-question/viewall-question.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddTestComponent,
    AdminHomeComponent,
    AssignTestComponent,
    CreateQuestionComponent,
    CreateUserComponent,
    LogoutComponent,
    UpdateUserComponent,
    UserHomeComponent,
    UserListComponent,
    ViewAllTestComponent,
    ViewallQuestionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
