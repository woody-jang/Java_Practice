#include <stdio.h>
#include <stdlib.h>

typedef struct data {
	int data;
	struct data* link;
} List;

List* getNode(void) {
	List* newNode = (List*)malloc(sizeof(List));
	newNode->data = 0;
	newNode->link = NULL;
	return newNode;
}

// 재귀함수 : 규칙성은 있지만, 같은 내용이 안되는 반복을 처리하기 위한 방법
void add(List** head, int data) {
	if (*head == NULL) {
		*head = getNode();
		(*head)->data = data;
	}
	else add(&(*head)->link, data);
}

void del(List** head, int find_data) {
	if (*head == NULL) {
		printf("찾고자하는 값이 없습니다.\n");
		return;
	}
	else if ((*head)->data == find_data) {
		List* tmp = *head;
		*head = (*head)->link;
		free(tmp);
	}
	else del(&(*head)->link, find_data);
}

void modify(List** head, int find_data, int after_data) {
	if (*head == NULL) {
		printf("찾는 값이 없습니다.\n");
		return;
	}
	else if ((*head)->data == find_data) {
		(*head)->data = after_data;
	}
	else modify(&(*head)->link, find_data, after_data);
}

void insert(List** head, int find_data, int insert_data) {
	if (*head == NULL) {
		printf("찾는 값이 없습니다.\n");
		return;
	}
	else if ((*head)->data == find_data) {
		List* tmp = getNode();
		tmp->data = insert_data;
		tmp->link = (*head)->link;
		(*head)->link = tmp;
	}
	else insert(&(*head)->link, find_data, insert_data);
}

void check_duplicate(List* head, int data) {
	// 반복쪽이 훨씬 더 빠릅니다.
	while (head != NULL) {
		if (head->data == data) {
			printf("중복이 있습니다!\n");
			return;
		}
		head = head->link;
	}
}

void get_maximum(List* head) {
	int max = head->data;
	while (head != NULL) {
		if (head->data > max) {
			max = head->data;
		}
		head = head->link;
	}
	printf("최대값은 %d입니다.\n", max);
}

int main(void) {
	List* head = NULL;
	add(&head, 20);
	add(&head, 10);
	add(&head, 15);
	add(&head, 33);
	add(&head, 31);
	get_maximum(head);
	return 0;
}