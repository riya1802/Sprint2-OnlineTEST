import { Answer } from './answer';

export class Question{
    constructor(){}
    questionId:number;
    questionTitle:string;
    questionAnswer:number;
    questionMarks:number;
    chosenAnswer:number;
    marksScored:number;
    questionOptions:Answer[]=[];
}