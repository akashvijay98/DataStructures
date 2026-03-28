# 📚 LeetCode Problems — Grouped by Pattern & Data Structure

A curated reference of LeetCode problems organized by algorithmic pattern and primary data structure. Use this as a study guide to recognize problem types and apply the right technique.

---

## 🗂️ Table of Contents

- [Sliding Window](#-sliding-window)
- [Two Pointers / Binary Search](#-two-pointers--binary-search)
- [Backtracking](#-backtracking)
- [Graphs (BFS / DFS)](#-graphs-bfs--dfs)
- [Greedy / Intervals](#-greedy--intervals)
- [Heaps / Top-K](#-heaps--top-k)
- [Dynamic Programming](#-dynamic-programming)
- [Hashing / Prefix Sum](#-hashing--prefix-sum)
- [Problems with Multiple Patterns](#-problems-with-multiple-patterns)

---

## 🪟 Sliding Window

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| Sliding Window Maximum | Deque (`ArrayDeque`) | Monotonic queue to maintain maximums in O(n) |
| Sliding Window Median | PriorityQueue (Two Heaps) | Maintaining balanced max-heap and min-heap |
| Longest Repeating Character Replacement | HashMap | Tracking character frequency within a dynamic window |
| Longest Substring With At Most 2 Distinct Characters | HashMap | Using a map to track the rightmost index of characters |

**When to use:** The problem involves a contiguous subarray or substring, and you're asked to find the max/min/count meeting some condition.

---

## 🔢 Two Pointers / Binary Search

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| Three Sum | Array | Sorting followed by a `left` and `right` pointer search |
| Koko Eating Bananas | Array | Binary search on the "answer space" (speed k) |
| Search in Rotated Sorted Array | Array | Modified binary search with range checks |

**When to use:** The input is sorted (or can be), and you're searching for pairs/triplets, or binary searching on an answer value rather than an index.

---

## 🔙 Backtracking

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| Combination Sum | LinkedList, List | Recursive exploration of all combinations |
| Permutations | List | Recursive swap or "used" set approach for ordering |
| Subsets | List | Generating all power set combinations |

**When to use:** You need to enumerate all possible configurations (combinations, permutations, subsets), and invalid paths should be pruned early.

---

## 🌐 Graphs (BFS / DFS)

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| Number of Islands | Queue, 2D Array | BFS to visit all connected `'1'`s |
| Max Area of Island | 2D Array | DFS to calculate the size of connected components |
| Course Schedule | Queue, List (Adj. List) | Topological Sort (Kahn's Algorithm) |
| Binary Tree Level Order Traversal | Deque (Queue) | Level-by-level processing using a queue |

**When to use:** The problem involves traversing a graph, grid, or tree — either to find connectivity, shortest paths, or ordering dependencies.

---

## 📅 Greedy / Intervals

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| Merge Intervals | List, Array | Sorting by start time and merging overlapping ends |
| Insert Interval | List, Array | Handling non-overlapping, overlapping, and remaining intervals |
| Meeting Rooms II | PriorityQueue | Min-heap to track the earliest ending meeting |
| Meeting Rooms III | PriorityQueue | Two heaps for unused and used rooms |

**When to use:** The problem involves scheduling, interval overlap detection, or making locally optimal choices that lead to a globally optimal solution.

---

## 🏔️ Heaps / Top-K

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| K Closest Points to Origin | PriorityQueue (Max-Heap) | Maintaining the K smallest distances in a heap |
| Top K Frequent Elements | PriorityQueue, HashMap | Frequency map combined with a min-heap |
| Find Median from Data Stream | PriorityQueue (Two Heaps) | Balancing two heaps to find the middle element(s) |

**When to use:** You need to efficiently track the K largest/smallest elements, or find order statistics (like the median) in a dynamic dataset.

---

## 🧮 Dynamic Programming

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| Word Break | Boolean Array (DP table) | Building up feasibility for substring prefixes |

**When to use:** The problem has overlapping subproblems and optimal substructure — i.e., larger solutions can be built from smaller, cached results.

---

## #️⃣ Hashing / Prefix Sum

| Problem | Primary Data Structure(s) | Key Logic / Technique |
|---|---|---|
| Two Sum | HashMap | Complement tracking for O(n) lookup |
| Count the Number of Nice Subarrays | HashMap | Prefix sum approach to count odd number counts |

**When to use:** You need O(1) lookups for complements or counts, or you want to reduce a subarray problem to a prefix difference check.

---

## 🔀 Problems with Multiple Patterns

Several problems can be solved using more than one valid approach. Understanding the alternatives deepens pattern recognition.

### 1. Sliding Window Median
- **Current:** Two Heaps (PriorityQueues) — O(log k) per operation.
- **Alternative:** Sliding Window + Balanced BST (`TreeMap` in Java) — similar complexity, handles removals more naturally.

### 2. Number of Islands
- **Current:** BFS using a Queue.
- **Alternative:** DFS (as seen in *Max Area of Island*). BFS and DFS are interchangeable for connected-component problems in a grid.

### 3. Capacity to Ship Packages Within D Days
- **Current:** Binary Search on Answer + Greedy feasibility check — optimal approach.
- **Alternative:** A DP-based partition approach is theoretically possible but far less efficient for the given constraints.

### 4. Meeting Rooms II
- **Current:** Min-Heap tracking the earliest ending room.
- **Alternative:** Two Pointers / Chronological Ordering — sort start and end times separately, then iterate to find the maximum number of concurrent meetings.

---

## 💡 Pattern Recognition Cheat Sheet

| If the problem asks for... | Consider... |
|---|---|
| Max/min in a contiguous window | Sliding Window |
| Pairs/triplets summing to a target | Two Pointers |
| All possible combinations/subsets | Backtracking |
| Connected components / shortest path | BFS / DFS |
| Scheduling or overlap detection | Greedy / Intervals |
| The K largest or smallest elements | Heap |
| Overlapping subproblems | Dynamic Programming |
| O(1) lookups by value | HashMap / Hashing |
| Counting subarrays with a property | Prefix Sum |

---

*Happy coding! ⚡ Focus on recognizing the pattern first — the implementation follows naturally.*
