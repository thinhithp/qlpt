ALTER TABLE DICH_VU
    ADD CONSTRAINT  DICH_VU_NHA FOREIGN KEY (ID_NHA)
        REFERENCES NHA (ID);