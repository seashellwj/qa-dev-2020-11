/* eslint-env jest */

/**
 * @file Unit test for maxLength
 * @author
 */

import maxLength from './maxLength';

test('maxLength: value.length > max length, to be false', () => {
    expect(maxLength(10, 'abcdefghijk')).toBeFalsy();
    expect(maxLength(10, '12345678901')).toBeFalsy();
    expect(maxLength(0, 'abc')).toBeFalsy();
    expect(maxLength(-1, 'abc')).toBeFalsy();
});

test('maxLength: value.length = max length, to be true', () => {
    expect(maxLength(10, 'abcdefghij')).toBeTruthy();
    expect(maxLength(10, '1234567890')).toBeTruthy();
    expect(maxLength(0, '')).toBeTruthy();
});

test('maxLength: value.length < max length, to be true', () => {
    expect(maxLength(10, 'abcdefghi')).toBeTruthy();
    expect(maxLength(10, '100')).toBeTruthy();
    expect(maxLength(10, '')).toBeTruthy();
});

test('maxLength: value is null, to be false', () => {
    expect(maxLength(10, null)).toBeFalsy();
});

test('maxLength: value is number, to be false', () => {
    expect(maxLength(3, 1)).toBeFalsy();
    expect(maxLength(3, 100)).toBeFalsy();
    expect(maxLength(3, 1000)).toBeFalsy();
});

test('maxLength: max length is not a number, to be false', () => {
    expect(maxLength('a', 'a')).toBeFalsy();
    expect(maxLength(NaN, 'a')).toBeFalsy();
    expect(maxLength(NaN, '')).toBeFalsy();
});

test('maxLength: max Length is not a number and value is null, to be false', () => {
    expect(maxLength(NaN, null)).toBeFalsy();
});