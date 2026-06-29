-- Exercise 3: Stored Procedures
-- Assumed Schema:
--   Accounts(AccountID, CustomerID, AccountType, Balance)
--   Employees(EmployeeID, Name, DepartmentID, Salary)

-- Scenario 1: ProcessMonthlyInterest

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all savings accounts.');
END ProcessMonthlyInterest;
/


-- Scenario 2: UpdateEmployeeBonus

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_DepartmentID  IN Employees.DepartmentID%TYPE,
    p_BonusPercent  IN NUMBER
) AS
    v_RowsUpdated NUMBER;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_BonusPercent / 100)
    WHERE DepartmentID = p_DepartmentID;

    v_RowsUpdated := SQL%ROWCOUNT;
    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        v_RowsUpdated || ' employee(s) in Department ' ||
        p_DepartmentID || ' received a ' ||
        p_BonusPercent || '% bonus.'
    );
END UpdateEmployeeBonus;
/


-- Scenario 3: TransferFunds

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_FromAccountID  IN Accounts.AccountID%TYPE,
    p_ToAccountID    IN Accounts.AccountID%TYPE,
    p_Amount         IN NUMBER
) AS
    v_SourceBalance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance
    INTO v_SourceBalance
    FROM Accounts
    WHERE AccountID = p_FromAccountID
    FOR UPDATE;

    IF v_SourceBalance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001,
            'Insufficient balance in account ' || p_FromAccountID ||
            '. Available: $' || v_SourceBalance ||
            ', Requested: $' || p_Amount);
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_Amount
    WHERE AccountID = p_FromAccountID;

    UPDATE Accounts
    SET Balance = Balance + p_Amount
    WHERE AccountID = p_ToAccountID;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Transfer successful: $' || p_Amount ||
        ' moved from Account ' || p_FromAccountID ||
        ' to Account ' || p_ToAccountID || '.'
    );

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Source account ' || p_FromAccountID || ' not found.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/


-- Sample Execution Calls

EXEC ProcessMonthlyInterest;

EXEC UpdateEmployeeBonus(3, 10);

EXEC TransferFunds(101, 102, 500);
