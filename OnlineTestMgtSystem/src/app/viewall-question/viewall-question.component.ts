import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { Question } from '../entity/question';

@Component({
  selector: 'app-viewall-question',
  templateUrl: './viewall-question.component.html',
  styleUrls: ['./viewall-question.component.css']
})
export class ViewallQuestionComponent implements OnInit {

  questions:any;
  answers:any;
  constructor(private service:QuestionService) { }
  ngOnInit() {
    let resp=this.service.getQuestions();
    resp.subscribe((data)=>this.questions=data);
  }
  public delQuestion(qid){
    let resp= this.service.deleteQuestion(qid);
    resp.subscribe((data)=>this.questions=data);
   }
}
