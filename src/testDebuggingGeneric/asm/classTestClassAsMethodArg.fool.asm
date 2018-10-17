push 0
push 5
push 1
push classpaperino
new
lfp
push 8
push 1
push classpaperino
new
push -2
lfp
add
lw
copy
lw
push 2
add
lc
js
print
lfp
push 10
push 1
push classpippo
new
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
print
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 1
add
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
push 2
add
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 0
push 1
add
push 2
push 0
lfp
add
lw
calchoff
add
lw
bleq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 0
b label1
label0:
push 1
label1:
srv
sra
pop
pop
sfp
lrv
lra
js

function4:
cfp
lra
lfp
push 1
lfp
add
lw
copy
lw
push 0
add
lc
js
srv
sra
pop
pop
sfp
lrv
lra
js

function5:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
srv
sra
pop
sfp
lrv
lra
js

function6:
cfp
lra
lfp
push 1
lfp
add
lw
copy
lw
push 1
add
lc
js
srv
sra
pop
pop
sfp
lrv
lra
js
classpluto:
function2
function1
function3
classpippo:
function0
function1
classpaperino:
function4
function5
function6
classnull:
