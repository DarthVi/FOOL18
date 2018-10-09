push 0
push function4
lfp
push 4
push -1
push 2
push classpluto
new
lfp
push -2
lfp
add
lw
js
print
lfp
push 3
push 1
push classpippo
new
lfp
push -2
lfp
add
lw
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
classpluto:
function2
function1
function3
classpippo:
function0
function1
classnull:
