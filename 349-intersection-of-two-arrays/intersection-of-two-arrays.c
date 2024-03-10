int* intersection(int a[], int n1, int b[], int n2, int *rs){
    int flag_a[1001]={0};
    for(int i=0;i<n1;i++){
        flag_a[a[i]]++;
    }
    int n=n1<n2?n1:n2;
    int k=0;
    int *out=(int *)calloc(n,sizeof(int));
    for(int i=0;i<n2;i++){
        if(flag_a[b[i]]>=1){
            flag_a[b[i]]=0;
            out[k++]=b[i];
        }
    }
    *rs=k;
    return out;
}