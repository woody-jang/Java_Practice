// 퀵정렬 : pivot을 정하고 pivot보다 크면 오른쪽 작으면 왼쪽
//			이진트리로 분할해서 정렬

// 위 개념만 가지고 직접 만들어보기
// 인터넷은 이해하기 힘들어서 직접 만들어서 이해하기

public class QuickSortPractice {

	public static void main(String[] args) {
		int[] arr = new int[19];
		for (int i = 0; i < arr.length; i++) {
			int tmp = (int) (Math.random() * 1000) % 70;
			arr[i] = tmp;
		}
		int left = 0;
		int right = arr.length - 1; // j의 시작점이기때문에 index번호로 맞춰줌 -1
		System.out.println("정렬전");
		for (int i : arr) { System.out.print(i + " "); }
		System.out.println("\n-------------------\n\n");
		QuickSort(arr, left, right); // 정렬해야될 시작점과 끝점도 함께 넣어야지 정렬이 가능
	}

	static void QuickSort(int[] arr, int left, int right) {
		if (left < right) { // 시작점이 끝점보다 작지 않으면 쪼개진 배열이 하나 이하이기때문에 재귀 탈출
			int pivot = arr[left]; // pivot은 제일 왼쪽으로 지정
			int i = left, j = right; // 반복을 위한 변수 설정 i는 왼쪽에서 오른쪽 j는 오른쪽에서 왼쪽
			for (; i <= right; i++) {
				if (arr[i] > pivot) { // i번째가 pivot보다 크면
					for (; j >= left; j--) { // j번째를 확인해서
						if (arr[j] <= pivot) { // j번째가 pivot보다 작으면
							swap(arr, i, j); // 서로 swap
							break; // swap하고 난후 j는 고정해놓고 i번째 다시 체크
						}
						if (i >= j) { // i와 j가 교차하면 비교할 필요가 없기때문에 탈출
							i--; // 탈출하면서 마지막으로 체크했던 지점인 i--로 변경
							j--; // 만약 i와 j가 같다면 다시 for문을 돌기때문에 j도 같이 변경
							break;
						}
					}
				}
				if (i >= j) { // 위에서 마지막으로 체크했던건 pivot보다 무조건 작기때문에
					swap(arr, left, i); // pivot과 위치변경
					break; // 결국 pivot을 기점으로 왼쪽은 pivot보다 작은수 오른쪽은 pivot보다 큰수
				}
			}
			System.out.println("정렬중");
			for (int k : arr) {
				System.out.print(k + " ");
			}
			System.out.println();
			QuickSort(arr, left, i - 1); // pivot을 기준으로 좌/우 나눠서 정렬
			QuickSort(arr, i + 1, right); // 시작점과 끝점을 i +- 1로 지정
		}
	}

	static void swap(int[] arr, int a, int b) {
		int tmp = arr[b];
		arr[b] = arr[a];
		arr[a] = tmp;
	}

}
