-- Exercise 1: Control Structures
-- Assumed Schema:
--   Customers(CustomerID, Name, Age, Balance, IsVIP, LoanInterestRate)
--   Loans(LoanID, CustomerID, DueDate, Amount)

-- Scenario 1: Apply 1% discount on loan interest rate for customers above 60

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Age, LoanInterestRate
        FROM Customers;

    v_customer c_customers%ROWTYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer;
        EXIT WHEN c_customers%NOTFOUND;

        IF v_customer.Age > 60 THEN
            UPDATE Customers
            SET LoanInterestRate = LoanInterestRate - 1
            WHERE CustomerID = v_customer.CustomerID;
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/


-- Scenario 2: Set IsVIP = TRUE for customers with balance over $10,000

DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;

    v_customer c_customers%ROWTYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer;
        EXIT WHEN c_customers%NOTFOUND;

        IF v_customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = v_customer.CustomerID;
        END IF;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/


-- Scenario 3: Print reminder for loans due within the next 30 days

DECLARE
    CURSOR c_due_loans IS
        SELECT L.LoanID, L.DueDate, L.Amount,
               C.Name AS CustomerName
        FROM Loans L
        JOIN Customers C ON L.CustomerID = C.CustomerID
        WHERE L.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_loan c_due_loans%ROWTYPE;
BEGIN
    OPEN c_due_loans;
    LOOP
        FETCH c_due_loans INTO v_loan;
        EXIT WHEN c_due_loans%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'REMINDER: Dear ' || v_loan.CustomerName ||
            ', your loan (ID: ' || v_loan.LoanID ||
            ') of amount $' || v_loan.Amount ||
            ' is due on ' || TO_CHAR(v_loan.DueDate, 'DD-MON-YYYY') || '.'
        );
    END LOOP;
    CLOSE c_due_loans;
END;
/
