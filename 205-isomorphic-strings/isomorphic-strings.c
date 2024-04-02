int cmp(void const *pa,void const *pb){
    char a=*(char *)pa;
    char b=*(char *)pb;
    return a-b;
}
bool isIsomorphic(char a[], char b[]){
    int lenA=strlen(a),lenB=strlen(b);
    if(lenA!=lenA){
        return false;
    }
    else if(strcmp(a,b)==0){
        return true;
    }
    else {
        char flag[256]={[0 ... 255]='\0'};
        for(int i=0;i<lenA;i++){
            if(flag[a[i]]=='\0') {
                flag[a[i]]=b[i];
            }
            else if(flag[a[i]]==b[i]){
                continue;
            }
            else {
                return false;
            }
        }
        qsort(a,lenA,sizeof(char),cmp);
        qsort(b,lenB,sizeof(char),cmp);
        int one=1;
        int two=1;
        for(int i=0;i<lenA;i++){
            if(a[i]!=a[i+1]){
                one++;
            }
        }
        for(int i=0;i<lenB;i++){
            if(b[i]!=b[i+1]){
                two++;
            }
        }
        if(one==two){
            return true;
        }
        else {
            return false;
        }
    }
}