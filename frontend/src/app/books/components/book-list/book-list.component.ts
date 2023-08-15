import { Component } from '@angular/core';
import { BookService } from '../../services/book.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent {
  //Datos del book
  books: any[] = [];

  //Datos del author 
  authors: any[] = [];

  title: String = "";
  id: number = 0;
  //Declarar el formulario
  form!: FormGroup;

  constructor(private bookServ: BookService) {
    this.getBooks();
    this.getAuthor();
    this.formInit();
  }


  getBooks() {
    this.bookServ.list()
      .subscribe((res: any) => {
        this.books = res.content;
      })
  }

  //Inicializar el formulario
  formInit() {
    this.form = new FormGroup({
      'title': new FormControl('', [Validators.required, Validators.maxLength(150)]),
      'description': new FormControl('', [Validators.required]),
      'category': new FormControl('', [Validators.required]),
      'price': new FormControl('', [Validators.required]),
      'isbn': new FormControl('', [Validators.required]),
      'pages': new FormControl('', [Validators.required]),
      'publication_date': new FormControl('', [Validators.required]),
      'image': new FormControl('', [Validators.required]),
      'author': new FormGroup({
        'id': new FormControl('', [Validators.required])
      })
    })
  }

  //Evento para enviar los datos la backend
  onSubmit() {
    if (this.form.valid) {
      if (this.id == 0) {
        this.bookServ.save(this.form.value)
          .subscribe(res => {
            const btnClose = document.getElementById('btn-close');
            btnClose?.click();
            this.getBooks();
          })
      } else {
        this.bookServ.update(this.id, this.form.value)
          .subscribe(res => {
            const btnClose = document.getElementById('btn-close');
            btnClose?.click();
            this.id = 0;
            this.getBooks();
          })
      }
    }
  }

  //Lista de author
  getAuthor() {
    this.bookServ.getAuthor()
      .subscribe((res: any) => {
        this.authors = res.content;
      })
  }

  //Edit
  onEdit(book: any) {
    this.id = book.id;
    this.form.patchValue(book);
  }

  //Delete
  onDetele(id:number){
    this.bookServ.delete(id)
    .subscribe(res=>{
      this.getBooks();
    })
  }

  //Search
  onSearch() {
    if (this.title.length > 0) {
      this.bookServ.search(this.title)
        .subscribe((res: any) => {
          this.books = res;
        })
    } else {
      this.getBooks();
    }

  }


}
