void reverse(char str[],int i,int j){
    while(i<j){
        char tempChar=str[i];
        str[i]=str[j];
        str[j]=tempChar;
        i++;
        j--;
    }
}
char * reversePrefix(char * str, char ch){
    int i=0;
    for(i=0;str[i]!='\0';i++){
        if(str[i]==ch){
            break;
        }
    }
    if(str[i]==ch)
    reverse(str,0,i);
    return str;
}