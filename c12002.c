#include<stdio.h>
#include<math.h>

int find(int n)
{
	int quantity=9;
  	int bit=1;//��ʾλ��
  	int num=1;
  	char str[10];
  	while(n>(long)quantity*bit)//bitλ��������quantity*bit�������Ӷ�ȷ��bit
	{
    	n-=quantity*bit;
    	quantity*=10;
    	bit++;
  	}
  	num=(n-1)/bit+quantity/9;
  	sprintf(str,"%d",num);
  	return str[(n-1)%bit]-'0';
}
int main()
{
	int k;
	scanf("%d",&k);
	printf("%d",find(k));
	return 0;
	
}

