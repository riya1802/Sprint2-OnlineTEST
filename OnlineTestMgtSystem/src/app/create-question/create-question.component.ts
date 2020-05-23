import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Question } from '../entity/question';
import { Test } from '../entity/test';
import { Answer } from '../entity/answer';

@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {

  
  constructor(private service:QuestionService) { }
  
  message:any;
  question: Question=new Question();
  test:Test=new Test(0,"",null,0,0,0,null,null);
  testId:number;
  answerId:number;
  value:string;
  
  answer:Answer[]=[];
  answerId1:number;
  value1:string;
  answerId2:number;
  value2:string;
  answerId3:number;
  value3:string;
  answerId4:number;
  value4:string;

  
 questionOptions:Answer[] = [];
    

  
  ngOnInit() {
    this.question.questionOptions[4];
  }
   adQuestion(){
     let option1 = new Answer(this.answerId1, this.value1);
    this.question.questionOptions.push(option1);
    let option2 = new Answer(this.answerId2, this.value2);
    this.question.questionOptions.push(option2);
    let option3 = new Answer(this.answerId3, this.value3);
    this.question.questionOptions.push(option3);
    let option4 = new Answer(this.answerId4, this.value4);
    this.question.questionOptions.push(option4);

    let resp= this.service.addQuestion(this.testId,this.question);
    resp.subscribe((data)=>this.message=data);
   }
}
