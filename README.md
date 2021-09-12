Main file: [datarep.clj](https://github.com/mkersh/DataRep/blob/main/src/mambu/extensions/data_replication/datarep.clj) 
Key functions:
* ([resync-dwh](https://github.com/mkersh/DataRep/blob/5a18f4152f55fc4fc86b065466aa13d1df36057a/src/mambu/extensions/data_replication/datarep.clj#L587) ...) - Replicates data from a Mambu tenant to a local folder/file based data-lake/DWH

File [file_dwh.clj](https://github.com/mkersh/DataRep/blob/main/src/mambu/extensions/data_replication/file_dwh.clj) - Implements the folder/file based DWH
* This DWH is used to save Mambu data/objects when they are replicated
* ([save-object](https://github.com/mkersh/DataRep/blob/0cde6dbd9ba4497dee5b1b426223906c4318f6eb/src/mambu/extensions/data_replication/file_dwh.clj#L56) object context) - Saves an object to the DWH
    * Also see higher-level [datarep.clj](https://github.com/mkersh/DataRep/blob/main/src/mambu/extensions/data_replication/datarep.clj)::[save-object](https://github.com/mkersh/DataRep/blob/0cde6dbd9ba4497dee5b1b426223906c4318f6eb/src/mambu/extensions/data_replication/datarep.clj#L184) 
