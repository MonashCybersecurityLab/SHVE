# SHVE
This repository holds the implementation of our Symmetric-key Hidden Vector Encryption (SHVE) Scheme.

As a new cryptographic primitive, SHVE is the first HVE scheme only relies on the symmetric-key building block. It is much faster than its pairing-based antecedents. This work is a part of our ACM CCS'18 paper [1]. For the performance comparison, please refer to the paper.

## Requirements

* Git
* Java 8

* Maven

## Installation

```bash
git clone https://github.com/MonashCybersecurityLab/SHVE.git
cd SHVE
mvn package
```

That's all for the building process. You can include the java package in your project and use our SHVE scheme via the provided APIs.

## Usage

To see the example, please check the main function of **edu.monash.crypto.hve.SHVE** in the package.

The provided APIs capture the four basic operations (`setup`, `keyGen`, `Enc`, `Query`) for the HVE scheme with some modification. Specifically, the implementation is for the predicate-only construction, which means the message for `Enc` is always "True".

## Feedback

- [Submit an issue](https://github.com/MonashCybersecurityLab/SHVE/issues/new)
- Email the authors: shangqi.lai@monash.edu, sikhar.patranabis@iitkgp.ac.in

## Reference

[1] Shangqi Lai, Sikhar Patranabis, Amin Sakzad, Joseph K. Liu, Debdeep Mukhopadhyay, Ron Steinfeld, Shi-Feng Sun, Dongxi Liu, and Cong Zuo. 2018. Result Pattern Hiding Searchable Encryption for Conjunctive Queries. In 2018 ACM SIGSAC Conference on Computer and Communications Security (CCS ’18), October 15–19, 2018, Toronto, ON, Canada. ACM, New York, NY,
USA, 18 pages. https://doi.org/10.1145/3243734.3243753
