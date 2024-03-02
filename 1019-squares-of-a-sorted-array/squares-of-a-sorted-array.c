/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* sortedSquares(int a[],int n, int* r){
    *r=n;
    int *b=(int *)calloc(n,sizeof(int));
    int k=0;
    int neg=0;
    for(int i=0;i<n;i++){
        if(a[i]<0){
            neg++;
        }
        else {
            break;
        }
    }
    int i=neg-1;
    int j=neg;
    while(i>=0 && j<n){
        if(a[i]*a[i]<=a[j]*a[j]){
            b[k++]=a[i]*a[i];
            i--;
        }
        else {
            b[k++]=a[j]*a[j];
            j++;
        }
    }
    while(i>=0){
        b[k++]=a[i]*a[i];
            i--;
    }
    while(j<n){
         b[k++]=a[j]*a[j];
            j++;
    }
    return b;
}