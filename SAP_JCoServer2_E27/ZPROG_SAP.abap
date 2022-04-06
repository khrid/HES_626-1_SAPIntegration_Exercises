*&---------------------------------------------------------------------*
*& Report ZPROG_RFCSERVERC1_E27
*&---------------------------------------------------------------------*
*&
*&---------------------------------------------------------------------*
REPORT zprog_rfcserverc1_e27 MESSAGE-ID zmsg_e27.

DATA: gti_supplier TYPE zti_supplier_e27,
      gs_supplier  LIKE LINE OF gti_supplier.

PARAMETERS: pa_01 TYPE zde_iddepartment OBLIGATORY.

START-OF-SELECTION.
  CALL FUNCTION 'Z_FM_RFCSERVER_SUPPLIER2_E27' DESTINATION '2022_RFC_E27'
    EXPORTING
      iv_iddepartment       = pa_01
    IMPORTING
      et_suppliers          = gti_supplier
    EXCEPTIONS
      ex_empty              = 1
      ex_unknown            = 2
      communication_failure = 97
      system_failure        = 98
      OTHERS                = 99. "Don't forget the point


CASE sy-subrc.
    WHEN 0 .
      LOOP AT gti_supplier INTO gs_supplier.
        WRITE : / sy-tabix, gs_supplier.
      ENDLOOP .
    WHEN 1 .
      WRITE : / TEXT-001.
    WHEN 2 .
      WRITE : / TEXT-002.
    WHEN 97.
      WRITE : / TEXT-003.
    WHEN 98.
      WRITE : / TEXT-004.
    WHEN 99.
      WRITE : / TEXT-005.
  ENDCASE.
