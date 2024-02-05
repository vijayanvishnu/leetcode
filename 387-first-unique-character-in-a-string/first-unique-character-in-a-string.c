int firstUniqChar(char s[]){
    int flag[256];
    memset(flag,0,256*sizeof(int));
    int n=strlen(s);
    for(int i=0;i<n;i++){
        flag[s[i]]++;
    }
    for(int i=0;i<n;i++){
        if(flag[s[i]]==1){
            return i;
        }
    }
    return -1;
}