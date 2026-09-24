# Many Time Pad

This is an individual programming assignment about reusing a one-time-pad or
stream-cipher key. All eleven ciphertexts were encrypted with the same key, so
for any pair `Ci XOR Cj = Pi XOR Pj`; the key cancels out.

`solve.py` XORs every pair of known ciphertexts and counts positions where the
result looks like an ASCII letter. If a position is likely to contain a space
in one plaintext, the corresponding key byte is `ciphertext_byte XOR 0x20`.
Votes across all messages recover most of the target key. Standard crib-dragging
using readable English fragments resolves the remaining ambiguous bytes. The
target ciphertext is then XORed with the recovered key, and the script writes
the final plaintext to `secret.txt`.

Run it with:

```text
python solve.py
```

The script uses only the Python standard library and has no external
dependencies.
