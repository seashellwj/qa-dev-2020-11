/* eslint-env jest */

/**
 * @file Unit test for minLength
 * @author
 */

import minLength from './minLength';

test('minLength: value.length < min length, to be false', () => {
    expect(minLength(10, 'abc')).toBeFalsy();
    expect(minLength(10, '123')).toBeFalsy();
    expect(minLength(10, '')).toBeFalsy();
});

test('minLength: value.length = min Length, to be true', () => {
    expect(minLength(10, 'abcdefghij')).toBeTruthy();
    expect(minLength(10, '1234567890')).toBeTruthy();
    expect(minLength(0, '')).toBeTruthy();
});

test('minLength: value.length > min Length, to be true', () => {
    expect(minLength(5, 'abcdefghi')).toBeTruthy();
    expect(minLength(5, '123456')).toBeTruthy();
    expect(minLength(0, 'abc')).toBeTruthy();
    expect(minLength(-1, 'abc')).toBeTruthy();
});

test('minLength: value is null, to be false', () => {
    expect(minLength(10, null)).toBeFalsy();
});

test('minLength: value is number, to be false', () => {
    expect(minLength(3, 1)).toBeFalsy();
    expect(minLength(3, 100)).toBeFalsy();
    expect(minLength(3, 1000)).toBeFalsy();
});

test('minLength: min Length is not a number, to be false', () => {
    expect(minLength('a', 'a')).toBeFalsy();
    expect(minLength(NaN, 'a')).toBeFalsy();
    expect(minLength(NaN, '')).toBeFalsy();
});

test('minLength: min Length is not a number and value is null, to be false', () => {
    expect(minLength(NaN, null)).toBeFalsy();
});