import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { ViewallQuestionComponent } from './viewall-question/viewall-question.component';
import { HttpClientModule } from '@angular/common/http';
import { QuestionService } from './service/question.service';
import { FormsModule } from '@angular/forms';
import { AddTestComponent } from './add-test/add-test.component';
import { ViewAllTestComponent } from './view-all-test/view-all-test.component';
import { AssignTestComponent } from './assign-test/assign-test.component';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { LoginComponent } from './login/login.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { LogoutComponent } from './logout/logout.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateQuestionComponent,
    ViewallQuestionComponent,
    AddTestComponent,
    ViewAllTestComponent,
    AssignTestComponent,
    UserListComponent,
    CreateUserComponent,
    LoginComponent,
    AdminHomeComponent,
    LogoutComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [QuestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
