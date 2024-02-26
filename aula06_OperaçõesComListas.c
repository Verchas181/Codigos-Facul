/*
 _____                                                                       _      _       _
|  _  |                                                                     | |    (_)     | |
| | | | _ __    ___  _ __   __ _   ___   ___    ___  ___    ___  _ __ ___   | |     _  ___ | |_   __ _  ___
| | | || '_ \  / _ \| '__| / _` | / __| / _ \  / _ \/ __|  / _ \| '_ ` _ \  | |    | |/ __|| __| / _` |/ __|
\ \_/ /| |_) ||  __/| |   | (_| || (__ | (_) ||  __/\__ \ |  __/| | | | | | | |____| |\__ \| |_ | (_| |\__ \
 \___/ | .__/  \___||_|    \__,_| \___| \___/  \___||___/  \___||_| |_| |_| \_____/|_||___/ \__| \__,_||___/
       | |
       |_|


  */


// vamos criar a remoção de itens de uma Lista encadeada

// devemos criar um ponteiro "trash"
/*
if (head != NULL){
Node* trash = list->head;
list->head = list->head->next;
free(trash);
}
*/


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  #include "element.h" 
  
  LL* list_create();
void list_destroy(LL* list);
void list_insertFirst(LL* list, Element element);
void list_insertAfter(LL* list, int posicao, Element element);
void list_removeFirst()
vid list_print(LL* list);

#endif


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


bool list_removeFirst(LL* list){
  // lista vazia
  if(list->head == NULL){
    return false;
  }
  // lista n vazia
  Node* trash = list->head;
  list->head = list->head->next;
  free(trash);
  return true;
}

// para verificar a validade da funcao acima!!

void test_removeFirst(){
  LL* list = list_create();

  bool res =list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false");

  list_insertFirst(list,30);
  list_insertFirst(list,20);
  list_insertFirst(list,40);

  list_print(list);

  res = list_removeFirst(list); // true
  printf("%s \n",(res) ? "true" : "false");  
 res = list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false");// true
 res = list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false"); // true
 res = list_removeFirst(list);
  printf("%s \n",(res) ? "true" : "false"); // false

  list_destroy(list);

}


  bool list_removeAt(LL* list, int posicao){
    // caso de posicao invalida
    if (posicao < 0 || posicao >= list->size){
      return false;
    }
    if (posicao == 0){
     return list_removeFirst(list);
    }else{
      Node* prev = list->head;
      int i = 0;
      while(i < posicao - 1){
        prev= prev->next;
        i++;
    }
    Node* trash = prev->next;
    prev->next = trash-next; // ou  prev->next = prev->next->next;
    free(trash);
      list->size--;
    }

  return true;
  }

  void test_removeAt(){
  LL* list = list_create();
  bool res =list_removeAt(list);
  printf("%s \n",(res) ? "true" : "false");

  list_insertFirst(list,30);
  list_insertFirst(list,20);
  list_insertFirst(list,40);

  list_print(list);

  res = list_removeAt(list,-1); // fase
  printf("%s \n",(res) ? "true" : "false");  
  res = list_removeAt(list,10);
  printf("%s \n",(res) ? "true" : "false"); //false
  res = list_removeAt(list,1);
  printf("%s \n",(res) ? "true" : "false"); // true
  res = list_removeAt(list,0);
  printf("%s \n",(res) ? "true" : "false"); // true
  res = list_removeAt(list,0);
  printf("%s \n",(res) ? "true" : "false"); // true
  res = list_removeAt(list,0);
  printf("%s \n",(res) ? "true" : "false"); // false
  list_destroy(list);

  }

  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  // LISTA BIDIRECIONAL
  



  




















