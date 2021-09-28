


val example = Pair(1, Pair(2, Pair(3, End())))

assert(example(0) == Success(1))
assert(example(1) == Success(2))
assert(example(2) == Success(3))
assert(example(3) == Failure("Index out of bounds"))